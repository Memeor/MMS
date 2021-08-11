import React, { Component } from 'react';
import '../css/Login.css';

export class Login extends Component {
    render() {
        return (
            <div id="LoginComponent">
                <div id="MemeorTag">memeor</div>
                <h1>Member Login</h1>
                <input type="text" placeholder="Username"></input>
                <input type="text" placeholder="Password"></input>
                <button>Log in</button>
                <a href="/">Forgot password</a>
                <p>New User? <a href="/user-signup">Sign Up</a></p>
            </div>
        )
    }
}

export default Login;