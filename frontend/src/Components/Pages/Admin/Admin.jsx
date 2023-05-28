import React, { useEffect, useState } from 'react'
import { getSession } from "../../../session";
import { requestExpenses } from '../../../redux/main-reducer';
import RequestItem from '../../UI/RequestItem/RequestItem';
import cl from './Admin.module.css';
import { connect } from 'react-redux';
import { Loader } from '../../UI/loader';

const Admin = ({ requestExpenses, expenses, isFetching }) => {

    const [active, setActive] = useState(0);

    useEffect(() => {
        requestExpenses()
    }, [])

    if (isFetching) {
        return (
            <Loader />
        )
    }

    let session = getSession();

    return (
        <div>
            <>
                {
                    session.email !== "admin@admin.ru" ? (
                        <>
                            <div className={cl.access_denied}>Доступ запрещен</div>
                        </>
                    ) :
                        <>
                            <div className='container'>
                                <div className={cl.requests__count}>
                                    Всего запросов: {expenses.length}
                                </div>
                                <div className={cl.requests}>
                                    {expenses.length > 0 ? (expenses.map((request, index) =>
                                        <RequestItem
                                            request={request}
                                            key={request.id}
                                            number={index + 1}
                                            active={active === request.id}
                                            multiple={true}
                                            id={request.id}
                                            onToggle={(e) => setActive((a) => (a === request.id ? "" : request.id))}
                                        />
                                    )) : "История запросов пуста"}

                                </div>
                            </div>

                        </>
                }
            </>
        </div>
    )
}

const mapStateToProps = (state) => ({
    expenses: state.main.expenses,
    isFetching: state.main.isFetching
})

export const AdminContainer = connect(mapStateToProps, { requestExpenses })(Admin)