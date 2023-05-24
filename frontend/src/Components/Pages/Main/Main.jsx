import React, { useState } from 'react'
import Input from '../../UI/Input/Input'
import Select from 'react-select'
import cl from './Main.module.css'


const Main = () => {
    const [calc, setCalc] = useState({
        industry: "",
        team: "",
        landArea: "",
        objectsArea: "",
    })

    const options = [
        { value: 'Пищевая промышленность', label: 'Пищевая промышленность' },
    ]

    return (
        <div className='container'>
            <h1 className={cl.head}>
                Отчет о возможных затрататах на создание промышленного производства в городе Москве
            </h1>

            <form className={cl.form}>

                <div className={cl.flex__container}>
                    <div className={cl.input} >
                        <label>
                            Отрасль ведения хоз.деятельности
                        </label>
                        <Select
                            options={options}
                            onChange={(event) => setCalc((value) => (
                                {
                                    ...value
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

                <div className={cl.input}><Input type="text" label="Штатная численность сотрудников" value={calc.team} setValue={setCalc} /></div>
                <div className={cl.input}><Input type="text" label="Предполагаемая площадь земельного участка для расположения промышленного производства (в кв. м) " value={calc.landArea} setValue={setCalc} /></div>
                <div className={cl.input}><Input type="text" label="Планируемая площадь объектов капитального строительства" value={calc.objectArea} setValue={setCalc} /></div>


                <button className={cl.form__button}>
                    Рассчитать
                </button>
            </form >
        </div>
    )
}

export default Main