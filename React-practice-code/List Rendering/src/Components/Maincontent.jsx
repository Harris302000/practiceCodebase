

import { useContext, useState } from "react";
import { productContext } from "../App";
import { FaRegTrashCan } from "react-icons/fa6";

function Main() {


    let { productlist } = useContext(productContext)
    console.log(productlist);


    return (

        <>
            <header>
                <h1>Welcome</h1>
            </header>

            <main>
                <h3>To Do List</h3>

                <table>
                   
                        {
                        productlist.map((product)=>{
                            return (<tr key={product.id}>
                                <td><label>{product.name}</label></td>
                                <td><label>{product.cost}</label></td>
                                <td><input type="checkbox" checked={product.checked} /></td>
                                <td><FaRegTrashCan /></td>
                            </tr>)

                        })
                    }  
                    
                </table>
            </main>
        </>

    );
}

export default Main;