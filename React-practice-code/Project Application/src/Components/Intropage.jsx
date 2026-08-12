import React from "react";
import { Button } from "react-bootstrap";
import { Link, useParams } from "react-router-dom";

const Intropage = () => {
  let { username } = useParams();
  console.log(username);

  return (
    <div
      style={{
        fontFamily: "monospace"
      }}
    >
      <header
        style={{
          padding: "10px 20px",
          backgroundColor: "whitesmoke",
          height: "60px"
        }}
      >
        <label style={{ fontSize: "20px" }}> Hi, {username} 👋</label>
      </header>

      <div
        style={{
          padding: "20px",
        color: "aliceblue",
        textAlign: "center"
        }}
      >
        <center>
          <h2
            style={{
              padding: "50px",
              textShadow: "10px 10px 10px",
            }}
          >
            Discover Amazing Products, Welcome to ShopEase 💕
          </h2>
        </center>
          
        <div style={{fontSize : '22px'}}>
          
        <p>
          Shop the latest fashion, electronics, accessories, and lifestyle
          products at unbeatable prices. Enjoy a seamless shopping experience
          with secure payments and fast delivery.
        </p>

        <p>
          From fashion and electronics to jewelry and home essentials, discover
          premium products curated just for you.
        </p>

        <p>
          Browse thousands of quality products across multiple categories. Enjoy
          secure checkout, personalized recommendations, and lightning-fast
          delivery.
        </p>

        </div>

        <ul style={{textAlign:'left',display:'flex',flexDirection:'column',justifyContent: 'center',alignItems:'center',margin : '80px 0px', fontSize : '30px'}}>
          <li>🛒 20,000+ Products</li>
          <li>🚚 Fast Delivery</li>
          <li>💳 Secure Payments</li>
          <li>⭐ Trusted by Thousands</li>
        </ul>

        <Button as={Link} to="/Productpage" style={{marginBottom:'50px'}}>
          Start Shopping →
        </Button>
        
      </div>
    </div>
  );
};

export default Intropage;
