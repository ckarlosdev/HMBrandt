export type AuthUser = {
  email: string;
  fullName: string;
  id: string;
  roles: Role[];
};

export type Role = {
    id: number;
    name: string;
}