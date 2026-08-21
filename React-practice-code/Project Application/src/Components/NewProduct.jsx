import React, { useReducer, useState } from "react";
import Paper from "@mui/material/Paper";
import { TextField } from "@mui/material";
import { Button } from "react-bootstrap";

const NewProduct = () => {
  let handleAddData = () => {};

  let [data, setData] = useState({
    title: "",
    price: 500,
    description: "Custom discription",
    image: "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_t.png",
    category: "",
    rating: {
      rate: 0,
      count: 0,
    },
  });

  let handleData = (e) => {
    
    let name = e.target.name
    let value = e.target.value

    let newdata = {...data, [name] : value};
    setData(newdata)
    
  };

  return (
    <div style={{ display: "flex", justifyContent: "center" }}>
      <Paper
        elevation={3}
        style={{
          display: "flex",
          flexDirection: "column",
          width: "400px",
          margin: "50px auto",
          padding: "20px",
          border: "0.5px dotted black",
          gap: "20px",
        }}
      >
        {/* <section> */}
        <TextField
          name="title"
          label="title"
          variant="outlined"
          value={data.title}
          onChange={(e) => {
            handleData(e);
          }}
          fullWidth
        />

        <TextField
          name="category"
          label="category"
          variant="outlined"
          value={data.category}
          onChange={(e) => {
            handleData(e);
          }}
          fullWidth
        />

        <div
          style={{
            display: "flex",
            gap: "20px",
          }}
        >
          <TextField
            type="number"
            name="rating.rate"
            label="rate"
            variant="outlined"
            value={data.rating.rate}
            onChange={(e) => {
              handleData(e);
            }}
            style={{ width: "40%" }}
          />

          <TextField
            type="number"
            name="rating.count"
            label="count"
            variant="outlined"
            value={data.rating.count}
            onChange={(e) => {
              handleData(e);
            }}
            style={{ flex: "1" }}
          />
        </div>

        <Button variant="dark" onClick={handleAddData}>
          Add
        </Button>
        {/* </section> */}
      </Paper>
    </div>
  );
};

export default NewProduct;
