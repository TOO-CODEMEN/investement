// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";
import {createUserWithEmailAndPassword, signInWithEmailAndPassword, getAuth} from "firebase/auth";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
    apiKey: "AIzaSyDbCIJemyly-tYGASYMjcTOfAISBRRH_MM",
    authDomain: "react-calc-6f936.firebaseapp.com",
    projectId: "react-calc-6f936",
    storageBucket: "react-calc-6f936.appspot.com",
    messagingSenderId: "265152255496",
    appId: "1:265152255496:web:a91b5effa022c483e5a3bd",
    measurementId: "G-0KG5GMEHM9"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);

export const createUser = async (email, password) => {
    return createUserWithEmailAndPassword(getAuth(app), email, password);
}

export const signInUser = async (email, password) => {
    return signInWithEmailAndPassword(getAuth(app), email, password);
}