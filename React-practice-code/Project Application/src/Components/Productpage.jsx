import React, { useEffect, useState } from "react";
import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";
import { Atom } from "react-loading-indicators";
import useFetch from "../Customhooks/useFetch";

const Productpage = () => {
  // let [product, setProduct] = useState([]);
  // let [error, setError] = useState(false);
  // let [isLoading, setIsLoading] = useState(true);

  
  let {product , error ,isLoading} = useFetch("https://fakestoreapi.com/products")


  useEffect(() => {
      console.table(product)

  }, [product]);

  if (isLoading) {
    return (
      <div
        style={{
          width: "100%",
          height: "80vh",
          display: "flex",
          justifyContent: "center",
          alignItems: "center",
        }}
      >
        <Atom color="#32cd32" size="large" text="Loading" textColor="" />
      </div>
    );
  }

  return (
    <div>
      <h3 style={{padding:'20px', textAlign : 'right'}}>Total Product - {product.length}</h3>
      {product.length !== 0 && (
        <section className="card-main-div">
          {product.map((p) => {
            return (
              <Card key={p.id} style={{ width: "18rem", flexGrow: "1" }}>
                <center>
                  <Card.Img
                    variant="top"
                    src={p.image}
                    style={{ width: "7rem", height: "7rem" }}
                  />
                </center>

                <Card.Body>
                  <Card.Title>{p.title}</Card.Title>
                  {/* <Card.Subtitle>{p.category}</Card.Subtitle> */}
                  <Card.Text style={{ overflow: "scroll", height: "200px" }}>
                    {p.description}
                  </Card.Text>
                  <Card.Footer
                    style={{
                      display: "flex",
                      alignItems: "center",
                      justifyContent: "space-between",
                    }}
                  >
                    <Button variant="primary">Add to cart</Button>
                    <Card.Title>${p.price}</Card.Title>
                  </Card.Footer>
                </Card.Body>
              </Card>
            );
          })}
        </section>
      )}
      {error && <h1 style={{
          width: "100%",
          height: "80vh",
          display: "flex",
          justifyContent: "center",
          alignItems: "center",
        }}>Data not found</h1>}
    </div>
  );
};

export default Productpage;
