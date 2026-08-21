import React, { useEffect, useState } from "react";
import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";
import { Atom } from "react-loading-indicators";
import useFetch from "../Customhooks/useFetch";
import { FaCartPlus } from "react-icons/fa6";
import { FaEdit } from "react-icons/fa";
import { MdDeleteSweep } from "react-icons/md";
import Form from 'react-bootstrap/Form';

const Productpage = () => {
  // let [product, setProduct] = useState([]);
  // let [error, setError] = useState(false);
  // let [isLoading, setIsLoading] = useState(true);

  let { product, error, isLoading } = useFetch(
    "https://fakestoreapi.com/products",
  );

  useEffect(() => {
    console.table(product);
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
          textAlign: "center",
        }}
      >
        <Atom color="#32cd32" size="large" text="Loading" textColor="" />
      </div>
    );
  }

  return (
    <div>

    <header
        style={{
          padding: "10px 20px",
          backgroundColor: "whitesmoke",
          height: "60px"
        }}
      >
        <h3 style={{ padding: "5px", textAlign: "right" }}>
          Total Product - {product.length}
        </h3>
      </header>

      <div>
        
        {product.length !== 0 && (
          <section className="card-main-div">

          <div style={{display:'flex', flexDirection: 'row-reverse', width: '100%',gap : '20px'}}>
            <Form className="d-flex">
            <Form.Control
              type="search"
              placeholder="Search"
              className="me-2"
              aria-label="Search"
            />
            <Button variant="success">Search</Button>
          </Form>
          </div>

          

            <div className="products-card-div">
            {product.map((p) => {
              return (
                <Card key={p.id} style={{ width: "18rem", flexGrow: "1" }}>
                  <center>
                    <Card.Img
                      variant="bottom"
                      src={p.image}
                      style={{
                        width: "7rem",
                        height: "7rem",
                        padding: "10px",
                      }}
                    />
                  </center>

                  <Card.Body>
                    <Card.Title>{p.title}</Card.Title>
                    {/* <Card.Subtitle>{p.category}</Card.Subtitle> */}
                    {/* <Card.Text style={{ overflow: "scroll", height: "200px" }}>
                    {p.description}
                  </Card.Text> */}
                    <center>
                      <Card.Title>${p.price}</Card.Title>
                    </center>

                    <Card.Footer
                      style={{
                        display: "flex",
                        alignItems: "center",
                        justifyContent: "space-between",
                      }}
                    >
                      {/* <Button size="lg" variant="danger"><MdDeleteSweep /></Button>
                    <Button size="lg" variant="info"><FaEdit /></Button> */}
                      <Button size="lg" variant="primary">
                        <FaCartPlus />
                      </Button>
                    </Card.Footer>
                  </Card.Body>
                </Card>
              );
            })}
            </div>
          </section>
        )}
        {error && (
          <h1
            style={{
              width: "100%",
              height: "80vh",
              display: "flex",
              justifyContent: "center",
              alignItems: "center",
            }}
          >
            Data not found
          </h1>
        )}
      </div>

    {/* <footer
        style={{
          padding: "10px 20px",
          backgroundColor: "whitesmoke",
          height: "60px"
        }}
      >
        <h3 style={{ padding: "5px", textAlign: "right" }}>
          Total Product - {product.length}
        </h3>
    </footer> */}

    </div>
    
  );
};

export default Productpage;
