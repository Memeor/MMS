import './App.css';
import {
  BrowserRouter as Router,
  Switch,
  Route
} from "react-router-dom";

import AppInstall from './pages/AppInstall';
import Home from './pages/Home';
import UserSignup from './pages/UserSignup';
import Header from './components/Header';
import React from 'react';
import Login from './pages/Login';

function App() {
  return (
    <React.Fragment>

      <Router>
        <Header />
        <Switch>
          <Route path="/" component={Home} exact />
          <Route path="/install" component={AppInstall} />
          <Route path="/user-signup" component={UserSignup} />
          <Route path="/Login" component={Login} />
        </Switch>
      </Router>
    </React.Fragment>
  );
}

export default App;
