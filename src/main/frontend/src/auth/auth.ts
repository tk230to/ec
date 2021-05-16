import { auth } from "./firebase";

// Sign Up
export const createUserWithEmailAndPassword = (email: string, password: string) => {
  return auth.createUserWithEmailAndPassword(email, password);
};

// Sign In
export const signInWithEmailAndPassword = (email: string, password: string) => {
  return auth.signInWithEmailAndPassword(email, password);
};

// Sign out
export const signOut = () => {
  return auth.signOut();
};

// Password Reset
export const sendPasswordResetEmail = (email: string) => {
  return auth.sendPasswordResetEmail(email);
};

// Password Change
export const updatePassword = async (password: string) => {
  if (auth.currentUser) {
    return await auth.currentUser.updatePassword(password);
  }
  throw Error("No auth.currentUser!");
};
