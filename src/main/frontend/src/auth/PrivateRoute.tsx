import React from "react";
import { Route, RouteProps } from "react-router-dom";
import { useSelector } from 'react-redux'
import SignIn from '../views/pages/SignIn';
import { RootState } from '../stores';

interface MyRouteProps extends RouteProps {
  component:any;
  rest?:any
 }

const PrivateRoute: React.SFC<MyRouteProps> = ({ component: RouteComponent, ...options }) => {
  const currentUser = useSelector((state: RootState) => state.user.currentUser);
  console.log(currentUser)
  const Component = currentUser ? RouteComponent : SignIn;

  return <Route {...options} component={Component} />;
};

export default PrivateRoute;
