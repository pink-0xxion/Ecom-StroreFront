const ProductList = ({ products }) => {
    return (
        <div className="row">
            {products.map((product) => (
                <div className="col-lg-4 col-md-6 col-sm-12 mb-4" key={product.id}>
                    <div className="card h-100">
                        <img
                            src={product.imageUrl || `http://placehold.co/600x400`}
                            className="card-img-top"
                            alt={product.name} />
                        <div className="card-body">
                            <h5 className="card-title">{product.name}</h5>
                            <p className="card-text">{product.description}</p>
                            <p className="card-text"><strong>${product.price}</strong></p>
                        </div>
                    </div>
                </div>

                // <ul>
                //     <li>{product.name}</li>
                //     <li>{product.description}</li>
                //     <li>{product.imageUrl}</li>
                //     <li>{product.price}</li>
                // </ul>
            ))}
        </div>
    );
};

export default ProductList;

/*
col-lg-4 col-md-6 col-sm-12 <---ultimate solution
Large screen (lg): Takes 4 columns → 3 (12/4=3) items in a row.
Medium screen (md): Takes 6 columns → 2 (12/2=6) items in a row.
Small screen (sm): Takes 12 columns → 1 (12/12=1) items in a row.
*/