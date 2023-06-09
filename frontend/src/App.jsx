import './App.css';
import { HeaderContainer } from './Components/Header/Header';
import Login from './Components/Pages/Login/Login';
import { MainContainer } from './Components/Pages/Main/Main';
import { BrowserRouter, Route, Routes, Navigate } from "react-router-dom";
import { RegisterContainer } from './Components/Pages/Registration/Register';
import { AdminContainer } from './Components/Pages/Admin/Admin';
import { store } from './redux/store';
import { Provider } from 'react-redux';

function App() {
  return (
    <Provider store={store}>
      <BrowserRouter>
        <div className="App">
          <HeaderContainer />
          <Routes>
            <Route path="/register" Component={RegisterContainer} />
            <Route path="/login" Component={Login} />
            <Route path="/main" Component={MainContainer} />
            <Route path="/admin" Component={AdminContainer} />
            <Route path="*" element={<Navigate to="/main" />} />
          </Routes>
        </div>
      </BrowserRouter>
    </Provider>
  );
}

export default App;
