import React from 'react'
import { NavLink } from 'react-router-dom'
import cl from './Header.module.css'

const Header = () => {
    return (
        <div className={cl.Header}>
            <div className={cl.Login}><NavLink to="/login">Вход</NavLink></div>
        </div>
    )
}

export default Header;