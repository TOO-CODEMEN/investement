import React, { useEffect } from 'react'
import { getSession } from "../../../session";
import { requestExpenses } from '../../../redux/main-reducer';
import { connect } from 'react-redux';
import { Loader } from '../../UI/loader';

const Admin = ({ requestExpenses, expenses, isFetching }) => {

    useEffect(() => {
        requestExpenses()
    }, [])

    console.log(expenses)

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
                            <div className="a">Ты кто такой?</div>
                        </>
                    ) :
                        <>
                            <div>
                                Всего запросов: {expenses.length}
                            </div>
                            {expenses.length > 0 ? expenses.map(el => <div>{el.headcount}</div>) : "История запросов пуста"}
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