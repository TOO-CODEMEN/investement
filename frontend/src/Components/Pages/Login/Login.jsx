import React, { useState } from 'react'
import cl from "./Login.module.css"
import Input from "../../UI/Input/Input"
import { NavLink } from 'react-router-dom'

const Login = () => {
    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")

    return (
        <div className={cl.Authorization}>
            <div className={cl.Input}><Input value={email} setValue={setEmail} type="text" label="E-mail" /></div>
            <div className={cl.Input}><Input value={password} setValue={setPassword} type="password" label="Пароль" /></div>
            <button className={cl.Button}>Авторизоваться</button>
            <NavLink to={'/register'} className={cl.register__link}>
                Зарегистрироваться
            </NavLink>
        </div>
    )
}

export default Login