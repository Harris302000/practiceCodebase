import React from "react";
import Paper from "@mui/material/Paper";
import { TextField } from "@mui/material";
import { Button } from "react-bootstrap";

const NewProduct = () => {


    // "id": 1,
    // "title": "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
    // "price": 109.95,
    // "description": "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
    // "category": "men's clothing",
    // "image": "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_t.png",
    // "rating": {
    //   "rate": 3.9,
    //   "count": 120
    // }


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
        <TextField name="title" label="title" variant="outlined" fullWidth />

        <TextField
          name="category"
          label="category"
          variant="outlined"
          fullWidth
        />

        <div  style={{
          display: "flex",
          gap: "20px",
        }}>
          <TextField type="number" name="rating.rate" label="rate" variant="outlined" style={{width : '40%'}} />

          <TextField type="number" name="rating.count" label="count" variant="outlined" style={{flex : "1"}} />
        </div>

        <Button variant="dark"> Add</Button>
        {/* </section> */}
      </Paper>
    </div>
  );
};

export default NewProduct;
