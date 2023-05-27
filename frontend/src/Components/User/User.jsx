import React from 'react'
import cl from './user.module.css'

export const User = ({ userCurrent }) => {
    return (
        <div className={cl.user}>
            <h3 className={cl.head}>
                Ваши данные
            </h3>

            <h2 className={cl.name}>
                Ваше имя:
                <br />
                {userCurrent.name}
            </h2>

            <ul className={cl.list}>
                <li className={cl.list__item}>
                    <span className={cl.list__item__span}>
                        Город:
                    </span>

                    <div className={cl.list__item__div}>
                        {userCurrent.city}
                    </div>
                </li>

                <li className={cl.list__item}>
                    <span className={cl.list__item__span}>
                        Страна:
                    </span>

                    <div className={cl.list__item__div}>
                        {userCurrent.country}
                    </div>
                </li>

                <li className={cl.list__item}>
                    <span className={cl.list__item__span}>
                        Отрасль:
                    </span>

                    <div className={cl.list__item__div}>
                        {userCurrent.industry}
                    </div>
                </li>

                <li className={cl.list__item}>
                    <span className={cl.list__item__span}>
                        ИНН:
                    </span>

                    <div className={cl.list__item__div}>
                        {userCurrent.inn}
                    </div>
                </li>


                <li className={cl.list__item}>
                    <span className={cl.list__item__span}>
                        Должность:
                    </span>

                    <div className={cl.list__item__div}>
                        {userCurrent.job}
                    </div>
                </li>


                <li className={cl.list__item}>
                    <span className={cl.list__item__span}>
                        Название организации:
                    </span>

                    <div className={cl.list__item__div}>
                        {userCurrent.nameOrganization}
                    </div>
                </li>

                <li className={cl.list__item}>
                    <span className={cl.list__item__span}>
                        Веб-сайт:
                    </span>

                    <div className={cl.list__item__div}>
                        <a href={`${userCurrent.webSite}`} style= {{textDecoration: 'underline'}}>
                            {userCurrent.webSite}
                        </a>
                    </div>
                </li>
            </ul>
        </div>
    )
}