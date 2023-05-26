import React, { useEffect, useState } from 'react'
import { NavLink, useNavigate } from 'react-router-dom'
import cl from './Header.module.css'
import logo from '../../assets/img/logo.png'
import { getSession, isLoggedIn, endSession } from "../../session";

const Header = () => {
    const navigate = useNavigate()
    const [email, setEmail] = useState("")
    let session = getSession();

    useEffect(() => {
        setEmail(session.email)
        console.log("Your access token is: " + session.accessToken);
    }, [session.email]);

    const onLogout = () => {
        endSession();
        navigate("/main")
    }

    const onClickHandler = () => {
        if (email == 'admin@admin.ru') {
            navigate('/admin')
        }
    }

    return (
        <div className={cl.Header}>
            <NavLink to="/main" >
                <img src={logo} alt="Логотип" className={cl.header__logo} />
            </NavLink>
            <div className={cl.authorization}>
                <>
                    {
                        !isLoggedIn() ? (
                            <>
                                <div className={cl.authorization__link}><NavLink to="/login">Вход</NavLink></div>
                                <div className={cl.authorization__link}><NavLink to="/register">Регистрация</NavLink></div>
                            </>
                        ) :
                            <>
                                <div className={cl.authorization__link} onClick={
                                    onClickHandler
                                }>{email}</div>
                                <div className={cl.authorization__link} onClick={
                                    onLogout
                                }>Выйти</div>
                            </>
                    }
                </>

            </div>

        </div>
    )
}

export default Header;