import { Button, Card, Col, Container, Row, Spinner } from "react-bootstrap";
import hmbLogo from "./assets/hmbLogo.png";
import "./styles/buttons.css";
import { MdLogout } from "react-icons/md";
import { useState } from "react";
import { api } from "./hooks/apiConfig";
import { useAuthStore } from "../src/stores/authStore";
import useUserMe from "./hooks/useUser";
import { CARDS_DATA } from "./types/utils";

function App() {
  const handleNavigation = (url: string) => {
    console.log(url);
    window.location.href = url;
  };

  const [isLoading, setIsLoading] = useState(false);
  const { refreshToken, logout, user: userAuth, token } = useAuthStore();
  const { isLoading: loadingUser } = useUserMe();

  const handleLogout = async () => {
    setIsLoading(true);
    try {
      if (refreshToken) {
        await api.post("/auth/revoke", { refreshToken });
      }
    } catch (error) {
      console.error("Error revoking token, loging out local...", error);
    } finally {
      logout();
      window.location.href = "https://ckarlosdev.github.io/login/";
    }
  };

  if (loadingUser) {
    return <Spinner />;
  }

  // console.log("a", userAuth);
  const canAccess = (cardRoles: string[]) => {
    // Verificamos si alguno de los roles del usuario coincide con los requeridos
    return userAuth?.roles.some((role) => cardRoles.includes(role.name));
  };

  if (!token) {
    return (
      <div style={{ textAlign: "center", marginTop: "50px" }}>
        <h4>Session expired. Redirecting to login...</h4>
        <Button
          variant="outline-secondary"
          onClick={() =>
            (window.location.href = "https://ckarlosdev.github.io/login/")
          }
        >
          Go to Login
        </Button>
      </div>
    );
  }

  return (
    <Container fluid className="d-flex flex-column min-vh-100 p-0">
      <Row className="p-3 m-0 align-items-center">
        <Col className="d-flex justify-content-start"></Col>
        <Col xs="auto" className="text-center">
          <img style={{ width: "200px" }} src={hmbLogo} alt="" />
        </Col>
        <Col className="d-flex justify-content-end align-items-center gap-3">
          <div
            style={{
              fontSize: "0.85rem",
              color: "#6c757d",
              borderRight: "1px solid #dee2e6",
              paddingRight: "15px",
              fontWeight: "500",
            }}
          >
            <span style={{ opacity: 0.7 }}>User: </span>
            <span className="text-dark">{userAuth?.fullName || "Guest"}</span>
          </div>
          <Button
            variant="outline-secondary"
            size="sm"
            onClick={handleLogout}
            disabled={isLoading}
            style={{
              borderRadius: "10px",
              fontWeight: "bold",
              width: "120px",
              height: "40px",
              display: "flex",
              alignItems: "center",
              justifyContent: "center",
            }}
          >
            {isLoading ? (
              <span style={{ marginRight: "4px" }}>Logging out</span>
            ) : (
              <span style={{ marginRight: "4px" }}>Logout</span>
            )}
            <MdLogout size={18} />
          </Button>
        </Col>
      </Row>

      <Row className="flex-grow-1 m-0 bg-light">
        <Col className="d-flex justify-content-center p-4">
          <Row className="flex-grow-1 m-0">
            <Col className="d-flex justify-content-center p-4">
              <div style={{ width: "100%" }}>
                <h3 className="text-center mb-5">Select a Module</h3>

                <Row className="g-4 justify-content-center">
                  {CARDS_DATA.filter((card) =>
                    canAccess(card.requiredRoles),
                  ).map((modulo: any) => (
                    <Col key={modulo.name} xs={12} md={6} lg={4}>
                      <Card
                        className="p-5 bg-white shadow border rounded-4 text-center hover-shadow-lg transition w-100"
                        as="button"
                        onClick={() => handleNavigation(modulo.url)}
                        style={{
                          border: "none",
                          cursor: "pointer",
                          appearance: "none",
                        }}
                      >
                        <Card.Title
                          style={{ fontWeight: "bold", fontSize: "30px" }}
                        >
                          {modulo.name}
                        </Card.Title>
                        <Card.Body>
                          <img
                            style={{ width: "100px" }}
                            src={modulo.logo}
                            alt=""
                          />
                        </Card.Body>
                      </Card>
                    </Col>
                  ))}
                </Row>
              </div>
            </Col>
          </Row>
        </Col>
      </Row>
    </Container>
  );
}

export default App;
