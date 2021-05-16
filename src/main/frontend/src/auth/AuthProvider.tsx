import React, { useEffect } from "react";
import { useDispatch } from 'react-redux'
import { setCurrentUser } from "../stores/user";

import { auth } from "./firebase";

const AuthProvider = (props: any) => {
  const dispatch = useDispatch()

  useEffect(() => {
    // Firebase Authのメソッド。ログイン状態が変化すると呼び出される
    auth.onAuthStateChanged(user => {
      dispatch(setCurrentUser(user))
    });
  }, [dispatch]);

  return (
    <div>
      {props.children}
    </div>
  );
};

export { AuthProvider };
