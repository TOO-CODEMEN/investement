import React, { useState } from 'react'
import Input from '../../UI/Input/Input'
import Select from 'react-select'
import cl from './Main.module.css'
import { Modal } from '../../Modal/Modal'
import { Loader } from '../../UI/loader'
import Checkbox from '../../UI/Checkbox/Checkbox'
import { MapForm } from '../../UI/Map/Map'
import { industryOptions, hardwareOptions, objectTypeOptions } from '../../../data/data'
import { requestPostExpenses } from '../../../redux/main-reducer'
import { connect } from 'react-redux'

import { isLoggedIn } from '../../../session'
import { NavLink } from 'react-router-dom'


const Main = ({ requestPostExpenses, isFetching, costObject }) => {

    // Состояние модальных окон
    const [modalActive, setModalActive] = useState(false)
    const [modalMapActive, setModalMapActive] = useState(false)

    const [patent, setPatent] = useState(false)

    // Состояние объекта формы
    const [calc, setCalc] = useState({
        yearlyIncome: "",
        industry: "",
        headcount: "",
        productionArea: "",
        productionSquare: "",
        plannedAreaOfConstruction: "",
        equipment: "",
        typeOfBuilding: "",
        squareOfBuilding: "",
        typeOfOrganization: "OOO (AO)",
    })

    // фукнция, которая срабатывает при отправке формы
    const onSubmitHandler = (e) => {
        e.preventDefault()

        if (!calc.industry ||
            !calc.headcount ||
            !calc.productionArea ||
            !calc.productionSquare ||
            !calc.equipment ||
            !calc.plannedAreaOfConstruction ||
            !calc.squareOfBuilding ||
            !calc.typeOfBuilding ||
            !calc.yearlyIncome
        ) {
            alert('Введите все данные!')
            return;
        }

        let newCalc = {
            yearlyIncome: Number(calc.yearlyIncome),
            industry: calc.industry,
            headcount: Number(calc.headcount),
            productionArea: calc.productionArea,
            productionSquare: Number(calc.productionSquare),
            plannedAreaOfConstruction: Number(calc.plannedAreaOfConstruction),
            equipment: calc.equipment,
            typeOfBuilding: calc.typeOfBuilding,
            squareOfBuilding: Number(calc.squareOfBuilding),
            typeOfOrganization: calc.typeOfOrganization,
        }
        requestPostExpenses(newCalc)
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

                    <div className={cl.flex__containerRow}>
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

                        <div className={cl.input}><Input type="number" label="Штатная численность сотрудников" value={calc.headcount} setValue={setCalc} object={calc} typeObject={'headcount'} /></div>

                        <div className={cl.input}><Input type="number" label="Предполагаемая площадь земельного участка для расположения промышленного производства (в кв. м)" value={calc.productionSquare} setValue={setCalc} object={calc} typeObject={'productionSquare'} /></div>

                        <div className={cl.input}><Input type="number" label="Годовой доход" value={calc.yearlyIncome} setValue={setCalc} object={calc} typeObject={'yearlyIncome'} /></div>
                    </div>

                    <div className={cl.flex__containerRow}>
                        <div className={cl.input}><Input type="number" label="Планируемая площадь объектов капитального строительства" value={calc.plannedAreaOfConstruction} setValue={setCalc} object={calc} typeObject={'plannedAreaOfConstruction'} /></div>

                        <div className={cl.input} >
                            <label>
                                Предполагаемое к использованию оборудование
                            </label>
                            <Select
                                options={hardwareOptions}
                                onChange={(event) => setCalc((value) => (
                                    {
                                        ...value,
                                        ['equipment']: event.value
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

                        <div className={cl.input}>
                            <label >
                                Территория расположения объекта
                            </label>
                            <a
                                href='#'
                                onClick={
                                    () => setModalMapActive(true)
                                }
                                className={cl.map__button}
                            >
                                {calc.productionArea ? calc.productionArea : "Выбрать"}
                            </a>

                        </div>
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
                                    ['typeOfBuilding']: event.value
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
                    <div className={cl.input}><Input type="number" label="Площадь объекта" value={calc.squareOfBuilding} setValue={setCalc} object={calc} typeObject={'squareOfBuilding'} /></div>
                </div>
                <Checkbox id="patent" label="ИП" name="patent" checked={patent} setChange={setPatent} setCalcChange={setCalc} />

                <button className={cl.form__button}>
                    Рассчитать
                </button>
                {isLoggedIn() ? "" : <div className={cl.form__button__not__auth}>Вы не авторизованы, чтобы получить pdf-отчет нужно авторизоваться</div>}
            </form >

            <Modal active={modalActive} setActive={setModalActive}>

                {isFetching ?
                    <div>
                        <div className={cl.result}>
                            Подсчет данных
                        </div>
                        <Loader />
                    </div> :
                    <div>
                        <h3 className={cl.result}>
                            Результат
                        </h3>

                        <div className={cl.cost}>
                            <span>
                                Ваша расчетная стоимость:
                            </span>
                            <div>
                                {costObject.result} млн рублей
                            </div>
                        </div>

                        {isLoggedIn() ?

                            <div>
                                <a href='http://87.242.126.67:8080/api/expenses/download' className={cl.result__button} target='_blank'>
                                    Скачать отчет
                                </a>
                            </div>
                            :
                            <div>
                                <div>
                                    Для того чтобы скачать отчет, авторизуйтесь
                                </div>
                                <NavLink to="/login" className={cl.result__register}>Авторизация</NavLink>
                            </div>
                        }
                    </div>

                }
            </Modal >

            <Modal active={modalMapActive} setActive={setModalMapActive}>
                <div>
                    Выберите расположение
                </div>
                <br />
                <MapForm setValue={setCalc} typeObject={'productionArea'} setActive={setModalMapActive} />
            </Modal>
        </div >
    )
}

const mapStateToProps = (state) => ({
    costObject: state.main.costObject,
    isFetching: state.main.isFetching
})

export const MainContainer = connect(mapStateToProps, { requestPostExpenses })(Main)