function User(){
    return(
        <div className="dropdown">
            <a href="#" className="d-flex align-items-center link-dark text-decoration-none dropdown-toggle text-white"
               id="dropdownUser2" data-bs-toggle="dropdown" aria-expanded="false">
                <img src="https://github.com/mdo.png" alt="" width="32" height="32"
                     className="rounded-circle me-2"/>
                <strong>mdo</strong>
            </a>
            <ul className="dropdown-menu text-small shadow" aria-labelledby="dropdownUser2">
                <li><a className="dropdown-item text-white" href="#">New project...</a></li>
                <li><a className="dropdown-item text-white" href="#">Settings</a></li>
                <li><a className="dropdown-item text-white" href="#">Profile</a></li>
                <li>
                    <hr className="dropdown-divider"/>
                </li>
                <li><a className="dropdown-item text-white" href="#">Sign out</a></li>
            </ul>
        </div>
    );
}

export default User;
