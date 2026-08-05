import { useContext, useState } from "react";
import { productContext } from "../App";
import { FaRegTrashCan } from "react-icons/fa6";
import { FaRegEdit } from "react-icons/fa";

function Main() {
  let { productlist } = useContext(productContext);
//   console.log("productlist::" + JSON.stringify(productlist));

  let [prodname, setProdname] = useState("");

  let [data, setData] = useState(productlist);

//   console.log("data::" + JSON.stringify(data));

  const handleCheckbox = (id) => {
    // console.log("id::" + id);

    let newlist = data.map((product) => {
      return product.id === id
        ? { ...product, checked: !product.checked }
        : product;
    });

    // console.log("newlist::" + JSON.stringify(newlist));

    setData(newlist);
  };

  return (
    <>
      <header>
        <h1>Welcome</h1>
      </header>

      <main>
        <h3>To Do List</h3>

        <div className="input-div">
            <div>
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
          <input type="number" name="cost" id="cost" placeholder="Enter Cost" />
            </div>
          
          <button>Add</button>
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
                    <FaRegEdit id="edit" tabIndex={0} />{" "}
                    <FaRegTrashCan id="delete" tabIndex={0} />
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
