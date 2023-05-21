import React, { useState } from 'react'
import Input from '../../UI/Input/Input'
import cl from './Register.module.css'

export const Register = () => {

    const [register, setRegister] = useState({
        name: "",
        email: "",
        nameOrganization: "",
        inn: "",
        webSite: "",
        industry: "",
        country: "",
        city: "",
        job: ""
    })

    return (
        <div className={cl.container}>
            <form className={cl.form} onsubmit="return false;">
                <div className={cl.input}><Input type="text" placeholder="Введите ФИО..." value={register.name} setValue={setRegister} typeObject={'name'} required={true} /></div>
                <div className={cl.input}><Input type="email" placeholder="Введите email..." value={register.email} setValue={setRegister} typeObject={'email'} required={true} /></div>
                <div className={cl.input}><Input type="text" placeholder="Название организации" value={register.nameOrganization} setValue={setRegister} typeObject={'nameOrganization'} required={false} /></div>
                <div className={cl.input}><Input type="text" placeholder="ИНН" value={register.inn} setValue={setRegister} typeObject={'inn'} required={true} /></div>
                <div className={cl.input}><Input type="text" placeholder="Веб-сайт организации" value={register.webSite} setValue={setRegister} typeObject={'webSite'} required={false} /></div>
                <div className={cl.input}><Input type="text" placeholder="Отрасль ведения хоз.деятельности" value={register.industry} setValue={setRegister} typeObject={'industry'} required={false} /></div>
                <div className={cl.input}><Input type="text" placeholder="Страна" value={register.country} setValue={setRegister} typeObject={'country'} required={false} /></div>
                <div className={cl.input}><Input type="text" placeholder="Город" value={register.city} setValue={setRegister} typeObject={'city'} required={false} /></div>
                <div className={cl.input}><Input type="text" placeholder="Должность" value={register.job} setValue={setRegister} typeObject={'job'} required={false} /></div>
                <button onClick={
                    () => console.log(register)
                } className={cl.form__button}>
                    Зарегистрироваться
                </button>
            </form>
        </div>
    )
}