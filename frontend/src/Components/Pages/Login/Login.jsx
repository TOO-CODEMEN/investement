import React, { useState } from 'react'
import cl from "./Login.module.css"
import Input from "../../UI/Input/Input"
import { NavLink } from 'react-router-dom'

const Login = () => {
    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")

    return (
        <div className={cl.Authorization}>
            <div className={cl.Header}>Вход</div>
            <div className={cl.Input}><Input value={email} setValue={setEmail} type="text" placeholder="Введите email..." /></div>
            <div className={cl.Input}><Input value={password} setValue={setPassword} type="password" placeholder="Введите пароль..." /></div>
            <NavLink to={'/register'} className={cl.register__link}>
                Зарегистрироваться
            </NavLink>
            <button className={cl.Button} >Войти</button>
        </div>
    )
}

export default Login