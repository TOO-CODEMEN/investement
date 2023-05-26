import React from 'react'
import { getSession } from "../../../session";

const Admin = () => {

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
                            <div className="b">admin</div>
                        </>
                }
            </>
        </div>
    )
}

export default Admin