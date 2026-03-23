import assignment from "../assets/assignment.png";
import binder from "../assets/Binder.png";
import dashboard from "../assets/Dashboard.png";
import mdm from "../assets/mdm.png";
import shop from "../assets/shop.png";

export interface CardItem {
  name: string;
  logo: string;
  url: string;
  requiredRoles: string[];
}

export const CARDS_DATA: CardItem[] = [
  {
    name: "Issues",
    logo: shop,
    url: "https://ckarlosdev.github.io/main-issues/",
    requiredRoles: ["ROLE_ADMIN", "ROLE_OPERATION", "ROLE_SUPERINTENDENT", "ROLE_SUPERVISOR", "ROLE_USER"],
  },
  {
    name: "Dashboard",
    logo: dashboard,
    url: "https://ckarlosdev.github.io/Dashboard/",
    requiredRoles: ["ROLE_ADMIN", "ROLE_OPERATION", "ROLE_SUPERINTENDENT"],
  },
  {
    name: "Schedule",
    logo: assignment,
    url: "https://ckarlosdev.github.io/crew-assignment/",
    requiredRoles: ["ROLE_ADMIN", "ROLE_OPERATION", "ROLE_SUPERINTENDENT"],
  },
  {
    name: "Bider",
    logo: binder,
    url: "https://ckarlosdev.github.io/binder-webapp/",
    requiredRoles: ["ROLE_ADMIN", "ROLE_OPERATION", "ROLE_SUPERINTENDENT", "ROLE_SUPERVISOR", "ROLE_USER"],
  },
  {
    name: "MDM",
    logo: mdm,
    url: "https://ckarlosdev.github.io/mdm-control/",
    requiredRoles: ["ROLE_ADMIN", "ROLE_OPERATION"],
  },
];
