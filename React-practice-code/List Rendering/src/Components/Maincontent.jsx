import { useContext, useState } from "react";
import { productContext } from "../App";
import { FaRegTrashCan } from "react-icons/fa6";
import { FaRegEdit } from "react-icons/fa";
import { IoMdAddCircleOutline } from "react-icons/io";
import { AiTwotoneSave } from "react-icons/ai";



function Main() {
  let { productlist } = useContext(productContext);
  let [prodname, setProdname] = useState("");
  let [prodcost, setProdcost] = useState("");
  let [data, setData] = useState(productlist);
  let [editFlag, setEditFlag] = useState(false)
  let [curEleId, setcurEleId] = useState(null)


  const handleCheckbox = (id) => {

    let newlist = data.map((product) => {
      return product.id === id
        ? { ...product, checked: !product.checked }
        : product;
    });

    setData(newlist);
  };


  const handleDelete = (id) => {

    let newlist =  data.filter(item => item.id != id).map((item ,index) => {return {...item,id : index+1}})

    setData(newlist)

  }


  const handleEdit = (id) => {
      setEditFlag(true)

      let list = data.find(item => item.id === id);
      console.log("handleEdit::"+JSON.stringify(list) )

      setcurEleId(list.id)
      setProdname(list.name)
      setProdcost(list.cost)
  }

  const handleAddOrSave = () => {
      
    if(prodname === ''){
        alert('Enter the product name');
        return;
    }


    if(editFlag){

      let newlist = data.map((item) => { return (curEleId === item.id ? {...item, name : prodname , cost : prodcost}: item ) } )

      setData(newlist)
      setcurEleId(null)
      setProdname("")
      setProdcost("")
      setEditFlag(false)

    } else {

      
      let listArr = [...data,{id : data.length + 1 , name : prodname , cost : prodcost, checked : false}]
      setData(listArr)
      setProdname("")
      setProdcost("")
    }
  }


  return (
    <>
      <header>
        <h1>Welcome</h1>
      </header>

      <main>
        <h3>To Do List</h3>

        <div className="input-div">
          <input
            type="text"
            name="product"
            id="product"
            placeholder="Enter Product"
            value={prodname}
            onChange={(e) => {
              setProdname(e.target.value);
            }}
          />
          <input type="number" name="cost" id="cost" placeholder="Enter Cost" value={prodcost} onChange={(e) => setProdcost(e.target.value)}/>
            
          
          <button onClick={handleAddOrSave}>{editFlag ? <AiTwotoneSave />  : <IoMdAddCircleOutline /> }</button>
        </div>

        <table>
          <tbody>
            {data.map((product) => {
              return (
                <tr key={product.id}>
                  <td>
                    <input
                      type="checkbox"
                      checked={product.checked}
                      onChange={(e) => {
                        handleCheckbox(product.id);
                      }}
                    />
                  </td>
                  <td>
                    <label>{product.name}</label>
                  </td>
                  <td>
                    <label>{product.cost}</label>
                  </td>
                  <td>
                    <FaRegEdit id="edit" tabIndex={0} onClick={() => handleEdit(product.id)}/>{" "}
                    <FaRegTrashCan id="delete" tabIndex={0} onClick={ () => handleDelete(product.id)}/>
                  </td>
                </tr>
              );
            })}
          </tbody>
        </table>
      </main>
    </>
  );
}

export default Main;
