import { create } from "zustand";
import type { AuthUser } from "../types";

interface AuthState {
  token: string | null;
  refreshToken?: string | null;
  isAuthenticated: boolean;
  activeModule: string;
  user: AuthUser | null;
  login: (token: string, refreshToken: string) => void;
  logout: () => void;
  setUser: (user: AuthUser | null) => void;
  clearAuth: () => void;
}

const storedToken = localStorage.getItem("auth_token");
const storedRefreshToken = localStorage.getItem("refresh_token");

export const useAuthStore = create<AuthState>((set) => ({
    token: storedToken,
    refreshToken: storedRefreshToken,
    isAuthenticated: !!storedToken,

//   token:
//     "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX0FETUlOIl0sInN1YiI6ImNyYW1pcmV6QGhtYnJhbmR0LmNvbSIsImlhdCI6MTc3Mzc3ODQzNiwiZXhwIjoxNzczNzc5MzM2fQ.zdT577mRt8UryijY50lYjjrPaVS3-bTLkP9Uz7p2o34",
//   refreshToken:
//     "a132fd94-f196-49b8-a158-59a40beca80b.d126eaac-a456-4a87-8d0c-1b2d2a546420",
//   isAuthenticated: true,

  activeModule: "Home",
  user: null,
  showModal: false,
  typeData: "Error",
  modalText: "Mensaje",

  setActiveModule: (module: string) => set({ activeModule: module }),

  login: (token: string, refreshToken: string) => {
    localStorage.setItem("auth_token", token);
    localStorage.setItem("refresh_token", refreshToken);
    set({ token, refreshToken, isAuthenticated: true });
  },

  logout: () => {
    localStorage.removeItem("auth_token");
    localStorage.removeItem("refresh_token");
    set({
      token: null,
      isAuthenticated: false,
      user: null,
      refreshToken: null,
    });
  },

  setUser: (user) => set({ user }),
  clearAuth: () => set({ user: null, isAuthenticated: false }),
}));
