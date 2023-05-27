import React, { useEffect, useState } from 'react'
import { NavLink, useNavigate } from 'react-router-dom'
import cl from './Header.module.css'
import logo from '../../assets/img/logo.png'
import { getSession, isLoggedIn, endSession } from "../../session";
import { Modal } from '../Modal/Modal';

import { connect } from 'react-redux'
import { requestGetUser } from '../../redux/firebase-reducer'
import { Loader } from '../UI/loader';
import { User } from '../User/User';

const Header = ({ requestGetUser, userCurrent, isFetching }) => {
    const navigate = useNavigate()
    const [email, setEmail] = useState("")
    const [modalActive, setModalActive] = useState(false)
    let session = getSession();

    useEffect(() => {
        setEmail(session.email)
    }, [session.email]);

    const onLogout = () => {
        endSession();
        navigate("/main")
    }

    const onClickHandler = () => {
        if (email === 'admin@admin.ru') {
            navigate('/admin')
        } else {

            try {
                requestGetUser(email)
            } catch (e) {
                console.log(e)
            }
            setModalActive(true)
        }
    }

    return (
        <div className={cl.Header}>
            <NavLink to="/main" >
                <img src={logo} alt="Логотип" className={cl.header__logo} />
            </NavLink>
            <div className={cl.authorization}>
                <>
                    {
                        !isLoggedIn() ? (
                            <>
                                <div className={cl.authorization__link}><NavLink to="/login">Вход</NavLink></div>
                                <div className={cl.authorization__link}><NavLink to="/register">Регистрация</NavLink></div>
                            </>
                        ) :
                            <>
                                <div className={cl.authorization__link} onClick={
                                    () => onClickHandler()
                                }>{email}</div>
                                <div className={cl.authorization__link} onClick={
                                    onLogout
                                }>Выйти</div>
                            </>
                    }
                </>

            </div>

            <Modal active={modalActive} setActive={setModalActive}>
                {isFetching
                    ?
                    <Loader />
                    :
                    <User userCurrent={userCurrent}/>
                }
            </Modal>

        </div>
    )
}

const mapStateToProps = (state) => ({
    userCurrent: state.firebase.userCurrent,
    isFetching: state.firebase.isFetching
})

export const HeaderContainer = connect(mapStateToProps, { requestGetUser })(Header)