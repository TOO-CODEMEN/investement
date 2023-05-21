import React, { useState } from 'react'
import cl from "./Login.module.css"
import Input from "../Input/Input"

const Login = () => {
    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")

    return (
        <div className={cl.Authorization}>
            <div className={cl.Header}>Вход</div>
            <div className={cl.Input}><Input value={email} setValue={setEmail} type="text" placeholder="Введите email..." /></div>
            <div className={cl.Input}><Input value={password} setValue={setPassword} type="password" placeholder="Введите пароль..." /></div>
            <button className={cl.Button}>Войти</button>
        </div>
    )
}

export default Login