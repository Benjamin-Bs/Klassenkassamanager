import React from 'react';
import logo from './logo.svg';
import './css/App.css';
import Sidebar from './Components/Sidebar';
import StudentTable from "./Components/StudentTable";
import User from "./Components/User";

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <Sidebar />

      </header>
    </div>
  );
}

function MyButton(){
  return(
      <button>Hello There</button>
  );
}

export default App;
