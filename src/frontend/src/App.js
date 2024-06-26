import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import HomeAdmin from './components/HomeAdmin';
import HomeUser from './components/HomeUser';
import ItemDetail from './components/ItemPurchase';

export default function App() {
    return (
        <Router>
            <Routes>
                <Route path="/home" element={<HomeAdmin />} />
                <Route path="/homeuser" element={<HomeUser />} />
                <Route path="/itemdetail" element={<ItemDetail />} />
            </Routes>
        </Router>

    )
}
git