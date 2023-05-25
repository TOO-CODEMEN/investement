import React, { useState, useEffect } from 'react'
import { useNavigate } from 'react-router-dom'
import Input from '../../UI/Input/Input'
import Select from 'react-select'
import cl from './Main.module.css'
import { Modal } from '../../UI/Modal/Modal'
import { endSession, getSession, isLoggedIn } from "../../../session";
import { Loader } from '../../UI/loader'


const Main = () => {

    const [modalActive, setModalActive] = useState(false)

    const [calc, setCalc] = useState({
        industry: "",
        team: "",
        landArea: "",
        objectsArea: "",
    })

    const navigate = useNavigate()

    const options = [
        { value: 'Пищевая промышленность', label: 'Пищевая промышленность' },
    ]

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

        if(!calc.industry || !calc.team || !calc.landArea || !calc.objectsArea) {
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
                            options={options}
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
                </div>

                <div className={cl.input}><Input type="text" label="Штатная численность сотрудников" value={calc.team} setValue={setCalc} object={calc} typeObject={'team'}/></div>
                <div className={cl.input}><Input type="text" label="Предполагаемая площадь земельного участка для расположения промышленного производства (в кв. м) " value={calc.landArea} setValue={setCalc} object={calc} typeObject={'landArea'}/></div>
                <div className={cl.input}><Input type="text" label="Планируемая площадь объектов капитального строительства" value={calc.objectsArea} setValue={setCalc} object={calc} typeObject={'objectsArea'}/></div>


                <button className={cl.form__button}>
                    Рассчитать
                </button>
            </form >

            <Modal active={modalActive} setActive={setModalActive}>
                <div>
                    Подсчет данных
                </div>
                <br/>
                <Loader />
            </Modal>
        </div>
    )
}

export default Main