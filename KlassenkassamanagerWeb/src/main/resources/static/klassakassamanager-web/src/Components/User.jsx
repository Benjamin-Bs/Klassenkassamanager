import React from 'react';
import {Link} from 'react-router-dom';
import Cookies from 'js-cookie';

function User() {

    const handleLogout = () => {
        Cookies.remove('username'); // Entfernen des Benutzernamens-Cookies
        Cookies.remove('loggedIn'); // Entfernen des loggedIn-Cookies
    };

    return (
        <div className="dropdown">
            <a href="#" className="d-flex align-items-center text-white text-decoration-none dropdown-toggle"
               id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
                <img src="https://github.com/mdo.png" alt="" width="32" height="32" className="rounded-circle me-2"/>
                <strong>{Cookies.get('username')}</strong>
            </a>
            <ul className="dropdown-menu dropdown-menu-dark text-small shadow" aria-labelledby="dropdownUser1">
                <li><a className="dropdown-item" href="#">Settings</a></li>
                <li><Link className="dropdown-item" to="/profile">Profile</Link></li>
                <li>
                    <hr className="dropdown-divider"/>
                </li>
                <li><Link className="dropdown-item" to="/login" onClick={handleLogout}>Sign out</Link></li>
            </ul>
        </div>
    );
}
export default User;
