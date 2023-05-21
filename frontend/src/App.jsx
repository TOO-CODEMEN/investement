import './App.css';
import Header from './Components/Header/Header';
import Login from './Components/Login/Login';
import Main from './Components/Main/Main';
import { BrowserRouter, Route, Routes, Navigate } from "react-router-dom";

function App() {
  return (
    <BrowserRouter>
      <div className="App">
        <Header />
        <Routes>
          <Route path="/login" Component={Login} />
          <Route path="/main" Component={Main} />
          <Route path="*" element={<Navigate to="/main" />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
