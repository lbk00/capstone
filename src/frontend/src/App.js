import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import HomeAdmin from './components/HomeAdmin';
import HomeUser from './components/HomeUser';
import ItemPurchase from './components/ItemPurchase';
import ShoppingCart from './components/ShoppingCart';
export default function App() {
    return (
        <Router>
            <Routes>
                <Route path="/home" element={<HomeAdmin />} />
                <Route path="/homeuser" element={<HomeUser />} />
                <Route path="/itempurchase" element={<ItemPurchase />} />
                <Route path="/shoppingcart" element={<ShoppingCart />} />
            </Routes>
        </Router>

    )
}
