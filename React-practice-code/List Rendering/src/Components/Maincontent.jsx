import { useContext, useEffect, useState } from "react";
import { productContext } from "../App";
import { FaAlignCenter, FaRegTrashCan } from "react-icons/fa6";
import { FaRegEdit } from "react-icons/fa";
import { IoMdAddCircleOutline } from "react-icons/io";
import { AiTwotoneSave } from "react-icons/ai";
import Axios from "axios";

function Main() {
  let { productlist } = useContext(productContext);
  let [prodname, setProdname] = useState("");
  let [prodcost, setProdcost] = useState("");
  // let [data, setData] = useState(productlist);
  let [data, setData] = useState([]);
  let [editFlag, setEditFlag] = useState(false);
  let [curEleId, setcurEleId] = useState(null);

  useEffect(() => {
    let fetchdata = async () => {
      try {
        let response = await Axios.get("http://localhost:8086/Todo/AllData");
        setData(response.data);
      } catch (error) {
        console.log(error.message);
      }
    };

    fetchdata();
  }, []);

  const handleCheckbox = (id) => {
    let newlist = data.map((product) => {
      return product.id === id
        ? { ...product, checked: !product.checked }
        : product;
    });



    async function updateCheckBox() {

        let inputData = {checked : newlist.find((product) => product.id === id).checked}
        console.log(inputData);
        

         try {
          let response = await Axios.patch(
            `http://localhost:8086/Todo/Update/CheckBox/${id}`,
            inputData,
            {
              headers: { "content-type": "application/json" },
            },
          );
          console.log(response);
          setData(response.data);

          setData(newlist);
        } catch (error) {
          setData(data);
        }
    }

    updateCheckBox();

   
  };

  const handleDelete = (id) => {
    // let newlist =  data.filter(item => item.id != id).map((item ,index) => {return {...item,id : index+1}})

    async function deleteData() {
      await Axios.delete(`http://localhost:8086/Todo/DeteleData/${id}`).then(
        (response) => console.log(response),
      );
    }

    deleteData();

    let newlist = data.filter((item) => item.id != id);

    setData(newlist);
  };

  const handleEdit = (id) => {
    setEditFlag(true);

    let list = data.find((item) => item.id === id);

    setcurEleId(list.id);
    setProdname(list.description);
    // setProdcost(list.cost)
  };

  const handleAddOrSave = () => {
    // if (prodname === "") {
    //   alert("Enter the product name");
    //   return;
    // }

    if (editFlag) {
      let newlist = data.map((item) => {
        return curEleId === item.id ? { ...item, description: prodname } : item;
      });

      let updateData = async () => {
        let inputData = { description: prodname };

        console.log(inputData);

        try {
          let response = await Axios.patch(
            `http://localhost:8086/Todo/Update/Description/${curEleId}`,
            inputData,
            {
              headers: { "content-type": "application/json" },
            },
          );
          console.log(response);
          // setData(response.data);

          setData(newlist);
        } catch (error) {
          setData(data);
        }

        // setData(newlist)
        setcurEleId(null);
        setProdname("");
        setProdcost("");
        setEditFlag(false);
      };

      updateData();
    } else {
      async function addData() {
        let listArr = [
          ...data,
          {
            id: data.length + 1,
            description: prodname,
            cost: prodcost,
            checked: false,
          },
        ];

        let inputData = {
          // id: data.length + 1,
          description: prodname,
          // cost: prodcost,
          checked: false,
        };

        console.log(inputData);

        try {
          let response = await Axios.post(
            "http://localhost:8086/Todo/AddData",
            inputData,
          );
          console.log(response);

          setData(listArr);
        } catch (error) {
          setData(data);
          console.log(error.response.data);
          alert(error.response.data)
        }

        setProdname("");
        setProdcost("");
      }

      addData();
    }
  };

  return (
    <>
      <header>
        <h3 style={{margin : '10px'}}>To Do List</h3>
      </header>

      <main>
        

        <div className="input-div">
          <input
            type="text"
            name="product"
            id="product"
            placeholder="Enter Product"
            value={prodname}
            style={{ width: "70%", height: "40px" }}
            onChange={(e) => {
              setProdname(e.target.value);
            }}
          />
          {/* <input type="number" name="cost" id="cost" placeholder="Enter Cost" value={prodcost} onChange={(e) => setProdcost(e.target.value)}/> */}

          <button
            style={{ width: "30%", height: "40px" }}
            onClick={handleAddOrSave}
          >
            {editFlag ? "Modify" : "Add"}
            {/* {editFlag ? <AiTwotoneSave /> : <IoMdAddCircleOutline />} */}
          </button>
        </div>

        <table style={{ width: "50%",padding : '0px 50px'}}>
          <tbody>
            {data.map((product) => {
              return (
                <tr key={product.id}>
                  <td >
                    <div style={{display:'flex',justifyContent: 'right',paddingRight : '80px'}}>
                        <input
                      type="checkbox"
                      checked={product.checked}
                      onChange={(e) => {
                        handleCheckbox(product.id);
                      }}
                    />
                    </div>
                    
                  </td>
                  <td style={{width : 'fixed', Overflow:'scroll' }}>
                    <label style={{textDecoration: product.checked ? "line-through" : "none"}}>{product.description}</label>
                  </td>
                  {/* <td>
                    <label>{product.cost}</label>
                  </td> */}
                  <td>
                    <div style={{display:'flex',justifyContent: 'space-around'}}>
                      <FaRegEdit
                      id="edit"
                      tabIndex={0}
                      onClick={() => handleEdit(product.id)}
                    />{" "}
                    <FaRegTrashCan
                      id="delete"
                      tabIndex={0}
                      onClick={() => handleDelete(product.id)}
                    />
                    </div>
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
