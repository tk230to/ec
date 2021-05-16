import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import * as serviceWorker from './serviceWorker';
import { Provider } from "react-redux";
import {
  BrowserRouter as Router,
  Switch,
  Route,
} from 'react-router-dom'

import store from "./stores";

// pages
import Top from './views/pages/Top'
import SignUp from './views/pages/SignUp'
import SignIn from './views/pages/SignIn'

// auth
import { AuthProvider } from "./auth/AuthProvider";
import PrivateRoute from "./auth/PrivateRoute";

// constants
import * as routes from './constants/routes'

ReactDOM.render(
  <Provider store={store}>
    <AuthProvider>
      <Router>
        <Switch>
          <Route exact path={routes.SIGN_IN} component={SignIn} />
          <Route exact path={routes.SIGN_UP} component={SignUp} />
          <PrivateRoute exact path={routes.TOP} component={Top} />
          <Route component={Top} />
        </Switch>
      </Router>
    </AuthProvider>
  </Provider>,
  document.getElementById('root')
);

serviceWorker.unregister();
