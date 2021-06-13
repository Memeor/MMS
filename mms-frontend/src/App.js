import './App.css';
import {
  BrowserRouter as Router,
  Switch,
  Route
} from "react-router-dom";

import AppInstall from './pages/AppInstall';
import Home from './pages/Home';


function App() {
  return (
    <Router>
    <div>

    </div>

    <Switch>
      <Route path="/" component={Home} exact/>
      <Route path="/install" component = {AppInstall} />
    
    </Switch>
    </Router>
  );
}

export default App;
