import React, { useState, useEffect } from 'react'
import { useNavigate } from 'react-router-dom'
import Input from '../../UI/Input/Input'
import Select from 'react-select'
import cl from './Main.module.css'
import { Modal } from '../../UI/Modal/Modal'
import { endSession, getSession, isLoggedIn } from "../../../session";
import { Loader } from '../../UI/loader'
import Checkbox from '../../UI/Checkbox/Checkbox'


const Main = () => {

    const [modalActive, setModalActive] = useState(false)

    const [calc, setCalc] = useState({
        industry: "",
        team: "",
        landArea: "",
        objectsArea: "",
        hardware: "",
        objectType: "",
        objectArea: "",
    })


    const navigate = useNavigate()

    const industryOptions = [
        { value: 'Пищевая промышленность', label: 'Пищевая промышленность' },
    ]

    const hardwareOptions = [
        { value: 'Токарные станки', label: 'Токарные станки' },
        { value: 'Фрезерные станки', label: 'Фрезерные станки' },
        { value: 'Разрезные станки', label: 'Разрезные станки' },
    ]

    const objectTypeOptions = [
        { value: 'Офисное здание', label: 'Офисное здание' },
        { value: 'Складское помещение', label: 'Складское помещение' },
    ]

    const [patent, setPatent] = useState(false)
    const [accounting, setAccounting] = useState(false)

    const patentChange = () => {
        setPatent(!patent);
    };

    const accountingChange = () => {
        setAccounting(!accounting);
    };

    // useEffect(() => {
    //     let session = getSession();
    //     console.log("Your access token is: " + session.accessToken);
    // }, []);

    // const onLogout = () => {
    //     endSession();
    //     navigate("/login");
    // }

    const onSubmitHandler = (e) => {
        e.preventDefault()

        if (!calc.industry || !calc.team || !calc.landArea || !calc.objectsArea) {
            alert('Введите все данные!')
            return;
        }

        console.log(calc)

        setModalActive(true)
    }

    return (
        <div className='container'>
            <h1 className={cl.head}>
                Отчет о возможных затрататах на создание промышленного производства в городе Москве
            </h1>

            <form className={cl.form} onSubmit={
                onSubmitHandler
            }>
                <div className={cl.flex__container}>
                    <div className={cl.input} >
                        <label>
                            Отрасль ведения хоз.деятельности
                        </label>
                        <Select
                            options={industryOptions}
                            onChange={(event) => setCalc((value) => (
                                {
                                    ...value,
                                    ['industry']: event.value
                                }))}
                            styles={{
                                control: (baseStyles, state) => ({
                                    ...baseStyles,
                                    borderRadius: 10,
                                    border: '2px solid #CCCCCC',
                                    padding: 2,
                                    fontSize: 15,
                                }),
                            }}

                            theme={(theme) => ({
                                ...theme,
                                borderRadius: 0,
                                colors: {
                                    ...theme.colors,
                                    primary25: '#fff',
                                    primary: 'red',
                                },
                            })}
                        />
                    </div>

                    <div className={cl.input}><Input type="text" label="Штатная численность сотрудников" value={calc.team} setValue={setCalc} object={calc} typeObject={'team'} /></div>
                    <div className={cl.input}><Input type="text" label="Предполагаемая площадь земельного участка для расположения промышленного производства (в кв. м) " value={calc.landArea} setValue={setCalc} object={calc} typeObject={'landArea'} /></div>
                </div>

                <div className={cl.flex__container}>
                    <div className={cl.input}><Input type="text" label="Планируемая площадь объектов капитального строительства" value={calc.objectsArea} setValue={setCalc} object={calc} typeObject={'objectsArea'} /></div>
                    <div className={cl.input} >
                        <label>
                            Предполагаемое к использованию оборудование
                        </label>
                        <Select
                            options={hardwareOptions}
                            onChange={(event) => setCalc((value) => (
                                {
                                    ...value,
                                    ['hardware']: event.value
                                }))}
                            styles={{
                                control: (baseStyles, state) => ({
                                    ...baseStyles,
                                    borderRadius: 10,
                                    border: '2px solid #CCCCCC',
                                    padding: 2,
                                    fontSize: 15,
                                }),
                            }}
                            theme={(theme) => ({
                                ...theme,
                                borderRadius: 0,
                                colors: {
                                    ...theme.colors,
                                    primary25: '#fff',
                                    primary: 'red',
                                },
                            })}
                        />
                    </div>
                </div>

                <div className={cl.flex__container}>
                    <div className={cl.input} >
                        <label>
                            Тип объекта
                        </label>
                        <Select
                            options={objectTypeOptions}
                            onChange={(event) => setCalc((value) => (
                                {
                                    ...value,
                                    ['objectType']: event.value
                                }))}
                            styles={{
                                control: (baseStyles, state) => ({
                                    ...baseStyles,
                                    borderRadius: 10,
                                    border: '2px solid #CCCCCC',
                                    padding: 2,
                                    fontSize: 15,
                                }),
                            }}

                            theme={(theme) => ({
                                ...theme,
                                borderRadius: 0,
                                colors: {
                                    ...theme.colors,
                                    primary25: '#fff',
                                    primary: 'red',
                                },
                            })}
                        />
                    </div>
                    <div className={cl.input}><Input type="text" label="Площадь объекта" value={calc.objectArea} setValue={setCalc} object={calc} typeObject={'objectArea'} /></div>
                </div>

                <Checkbox id="accounting" label="Предоставление бухгалтерских услуг" name="accounting" value="accounting" checked={accounting} onChange={accountingChange} />
                <Checkbox id="patent" label="Оформление патента (только для ИП)" name="patent" value="patent" checked={patent} onChange={patentChange} />

                <button className={cl.form__button}>
                    Рассчитать
                </button>
            </form >

            <Modal active={modalActive} setActive={setModalActive}>
                <div>
                    Подсчет данных
                </div>
                <br />
                <Loader />
            </Modal>
        </div>
    )
}

export default Main