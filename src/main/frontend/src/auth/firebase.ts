import "firebase/auth";
import "firebase/firebase-firestore";
import firebase from "firebase";

const config = {
  apiKey: "AIzaSyAaJqnPGdPJQZu0e0YPEh7P57YGUbALsRA",
  authDomain: "tk-ec-393e8.firebaseapp.com",
  projectId: "tk-ec-393e8",
  storageBucket: "tk-ec-393e8.appspot.com",
  messagingSenderId: "868551686382",
  appId: "1:868551686382:web:d39573e9dcfbcde85adbff",
  measurementId: "G-EW3Z7P3G4Q"
};

if (!firebase.apps.length) {
  firebase.initializeApp(config);
}

export const auth = firebase.auth();
