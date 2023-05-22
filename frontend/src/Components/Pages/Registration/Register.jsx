import React, { useState } from 'react'
import Input from '../../UI/Input/Input'
import cl from './Register.module.css'
import validator from 'validator';

export const Register = () => {

    const [register, setRegister] = useState({
        name: "",
        email: "",
        password: "",
        nameOrganization: "",
        inn: "",
        webSite: "",
        industry: "",
        country: "",
        city: "",
        job: ""
    })

    const submitHandler = event => {
        event.preventDefault();

        if (validator.isEmpty(register.name)) {
            alert("Введите ФИО")
        } else if (validator.isInt(register.name)) {
            alert("Введите ФИО верно")
        } else if (!validator.isEmail(register.email)) {
            alert("Вы не ввели E-mail")
        } else if (!validator.isStrongPassword(register.password, { minSymbols: 0 })) {
            alert("Пароль должен состоять из одной строчной, прописной буквы и цифры, не менее 8 символов")
        } else if (!validator.isInt(register.inn) || register.inn.length < 10) {
            alert("Введите верно ИНН, не менее 10 символов")
        } else {
            console.log('все норм')
        }
    }

    return (
        <div className='container'>
            <h4 className={cl.head}>
                Отчет о возможных затрататах на создание промышленного производства в городе Москве
            </h4>
            <form className={cl.form} onSubmit={
                submitHandler
            }>
                <div className={cl.flex__container}>
                    <div className={cl.input}><Input type="text" label="ФИО" value={register.name} setValue={setRegister} typeObject={'name'} /></div>
                    <div className={cl.input}><Input type="text" label="Страна" value={register.country} setValue={setRegister} typeObject={'country'} /></div>
                    <div className={cl.input}><Input type="text" label="Город" value={register.city} setValue={setRegister} typeObject={'city'} /></div>
                </div>

                <div className={cl.flex__container}>
                    <div className={cl.input}><Input type="text" label="ИНН" value={register.inn} setValue={setRegister} typeObject={'inn'} /></div>
                    <div className={cl.input}><Input type="text" label="Название организации" value={register.nameOrganization} setValue={setRegister} typeObject={'nameOrganization'} /></div>
                    <div className={cl.input}><Input type="text" label="Веб-сайт организации" value={register.webSite} setValue={setRegister} typeObject={'webSite'} /></div>
                    <div className={cl.input}><Input type="text" label="Отрасль ведения хоз.деятельности" value={register.industry} setValue={setRegister} typeObject={'industry'} /></div>
                    <div className={cl.input}><Input type="text" label="Должность" value={register.job} setValue={setRegister} typeObject={'job'} /></div>
                </div>

                <div className={cl.flex__container}>
                    <div className={cl.input}><Input type="email" label="E-mail" value={register.email} setValue={setRegister} typeObject={'email'} /></div>
                    <div className={cl.input}><Input type="password" label="пароль" value={register.password} setValue={setRegister} typeObject={'password'} /></div>
                </div>
                <button className={cl.form__button}>
                    Зарегистрироваться
                </button>
            </form >
        </div >
    )
}