import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import HomeAdmin from './components/HomeManager';
import HomeUser from './components/HomeUser';
import ItemPurchase from './components/ItemPurchase';
import ShoppingCart from './components/ShoppingCart';
import Dashboard from './components/adminpage/Dashboard';
export default function App() {
    return (
        <Router>
            <Routes>
                <Route path="/home" element={<HomeAdmin />} />
                <Route path="/homeuser" element={<HomeUser />} />
                <Route path="/itempurchase" element={<ItemPurchase />} />
                <Route path="/shoppingcart" element={<ShoppingCart />} />
                <Route path="/dashboard" element={<Dashboard />} />
            </Routes>
        </Router>

    )
}