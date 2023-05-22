import React from 'react'
import { NavLink } from 'react-router-dom'
import cl from './Header.module.css'
import logo from '../../assets/img/logo.png'

const Header = () => {
    return (
        <div className={cl.Header}>
            <NavLink to="/main" >
                <img src={logo} alt="Логотип" className={cl.header__logo} />
            </NavLink>
            <div className={cl.Login}><NavLink to="/login">Вход</NavLink></div>
        </div>
    )
}

export default Header;