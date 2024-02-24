import React, {useEffect, useState} from 'react';
import {FaUser} from "react-icons/fa";
import {FaLock} from "react-icons/fa";
import {GET} from "../../apiUtility";
import {Link} from 'react-router-dom';


function Login() {

    const [students, setStudents] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            const api = "";
            const data = await GET(api);
            setStudents(data);
        };
        fetchData();
    }, []);

    return (
        <div id="LoginPageDown">
            <form>
                <h1>Login</h1>
                <div>
                    <input type="type" placeholder="Username" required/>
                    <FaUser/>
                </div>
                <div>
                    <input type="password" placeholder="Password" required/>
                    <FaLock/>
                </div>
                <div>
                    <label><input type="checkbox"/> Remember me</label>
                    <a href="#">Forgot password?</a>
                </div>
                <Link to="/home">
                    <button type="submit">Login</button>
                </Link>
                <div>
                    <p>Don't have an account? <Link to="/register">Register</Link></p>
                </div>

            </form>
        </div>
    )
}

export default Login;
