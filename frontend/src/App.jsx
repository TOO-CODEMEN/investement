import './App.css';
import Header from './Components/Header/Header';
import Login from './Components/Pages/Login/Login';
import Main from './Components/Pages/Main/Main';
import { BrowserRouter, Route, Routes, Navigate } from "react-router-dom";
import { Register } from './Components/Pages/Registration/Register';

function App() {
  return (
    <BrowserRouter>
      <div className="App">
        <Header />
        <Routes>
          <Route path="/register" Component={Register} />
          <Route path="/login" Component={Login} />
          <Route path="/main" Component={Main} />
          <Route path="*" element={<Navigate to="/main" />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
