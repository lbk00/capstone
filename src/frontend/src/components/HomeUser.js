
import React, {useState} from 'react';
import 'swiper/css';
import 'swiper/css/navigation';
import { Navigation , Autoplay }from 'swiper/modules';
import { Pagination as SwiperPagination } from 'swiper/modules';
import { Swiper, SwiperSlide } from 'swiper/react';
import 'swiper/css';
import 'swiper/css/navigation';
import 'swiper/css/pagination';
import 'swiper/css/scrollbar';
import './swiper.css';

import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';
import IconButton from '@mui/material/IconButton';
import MenuIcon from '@mui/icons-material/Menu';




import {
    Avatar, BottomNavigationAction,
    Box, Breadcrumbs,
    ButtonGroup,
    Card,
    CardContent, CardMedia,
    Divider, Drawer,
    FormControl,
    Grid,
    Icon, Link, List, ListItem, ListItemButton, ListItemIcon, ListItemText, Menu, MenuItem, OutlinedInput,
    Pagination,
    ToggleButton, ToggleButtonGroup
} from '@mui/material';



export default function App() {
    {/*메뉴 이벤트 관리*/}
    const [anchorElUser, setAnchorElUser] = useState(null);
    const [anchorElProduct, setAnchorElProduct] = useState(null);
    const [anchorElOrdersheet, setAnchorElOrdersheet] = useState(null);
    const [anchorElInventory, setAnchorElInventory] = useState(null);
    const [anchorElSupplier, setAnchorElSupplier] = useState(null);

    const handleUserClick = (event) => {
        setAnchorElUser(event.currentTarget);
    };

    const handleProductClick = (event) => {
        setAnchorElProduct(event.currentTarget);
    };

    const handleOrdersheetClick = (event) => {
        setAnchorElOrdersheet(event.currentTarget);
    };

    const handleInventoryClick = (event) => {
        setAnchorElInventory(event.currentTarget);
    };

    const handleSupplierClick = (event) => {
        setAnchorElSupplier(event.currentTarget);
    };

    const handleCloseUser = () => {
        setAnchorElUser(null);
    };

    const handleCloseProduct = () => {
        setAnchorElProduct(null);
    };

    const handleCloseOrdersheet = () => {
        setAnchorElOrdersheet(null);
    };

    const handleCloseInventory = () => {
        setAnchorElInventory(null);
    };

    const handleCloseSupplier = () => {
        setAnchorElSupplier(null);
    };

    const openUser = Boolean(anchorElUser);
    const openProduct = Boolean(anchorElProduct);
    const openOrdersheet = Boolean(anchorElOrdersheet);
    const openInventory = Boolean(anchorElInventory);
    const openSupplier = Boolean(anchorElSupplier);

    {/*상품 메뉴 옆 Drawer*/}
    const [open, setOpen] = React.useState(false);
    const toggleDrawer = (newOpen) => () => {
        setOpen(newOpen);
    };
    const DrawerList = (
        <Box sx={{ width: 250 }} role="presentation" onClick={toggleDrawer(false)}>
            <List>
                {['전체보기'].map((text, index) => (
                    <ListItem key={text} disablePadding>
                        <ListItemButton>
                            <ListItemIcon>
                                <MenuIcon />
                            </ListItemIcon>
                            <ListItemText primary={text} />
                        </ListItemButton>
                    </ListItem>
                ))}
            </List>
            <Divider />
            <List>
                {['바지', '운동화', '트레이닝복', '티셔츠' , '점퍼'].map((text, index) => (
                    <ListItem key={text} disablePadding>
                        <ListItemButton>
                            <ListItemIcon>
                                {index % 2 === 0 ? <MenuIcon /> : <MenuIcon />}
                            </ListItemIcon>
                            <ListItemText primary={text} />
                        </ListItemButton>
                    </ListItem>
                ))}
            </List>
        </Box>
    );

    {/*상품 정렬 타입*/}
    const [sortType, setSortType] = useState('popularity');

    const handleSortTypeChange = (event, newSortType) => {
        if (newSortType !== null) {
            setSortType(newSortType);
        }
    };


    return (
        <div className="App">
            {/*최상단의 페이지 로고 및 프로필, 로그인 ,회원가입*/}
            <AppBar position="static" sx={{ bgcolor: 'white', color: 'black' }}>
                {/*상단페이지*/}
                <Toolbar>
                    <IconButton edge="start" color="inherit" aria-label="menu" sx={{ mr: 2 }}>
                        <Icon sx={{ mr: 1 }} />
                    </IconButton>
                    <Typography align="left" variant="h6" sx={{ flexGrow: 1 }}>
                        메인페이지
                    </Typography>
                    <Avatar>Lee</Avatar>
                    <Button color="inherit">Login</Button>
                    <Button color="inherit">Sign up</Button>
                </Toolbar>
            </AppBar>
            <Divider />
            {/*상품 목록 메뉴*/}
            <AppBar position="static" sx={{ bgcolor: 'white', color: 'black'}}>
                <Toolbar>
                    <div>
                        <Button sx={{ color: 'black' }} onClick={toggleDrawer(true)}>
                            <MenuIcon/>
                        </Button>
                        <Drawer open={open} onClose={toggleDrawer(false)}>
                            {DrawerList}
                        </Drawer>
                    </div>

                    <Button sx={{ width : 90, color: 'black' }}>바지</Button>
                    <Divider orientation="vertical" variant="middle" flexItem />
                    <Button sx={{ width : 90, color: 'black' }}>운동화</Button>
                    <Divider orientation="vertical" variant="middle" flexItem />
                    <Button sx={{ width : 90, color: 'black' }}>트레이닝복</Button>
                    <Divider orientation="vertical" variant="middle" flexItem />
                    <Button sx={{ width : 90, color: 'black' }}>티셔츠</Button>
                    <Divider orientation="vertical" variant="middle" flexItem />
                    <Button sx={{ width : 90, color: 'black' }}>점퍼</Button>
                    <Box sx={{ flexGrow: 1 }} />
                    <form noValidate autoComplete="off">
                        <FormControl sx={{ width: '25ch', bgcolor: 'white' }} size="small">
                            <OutlinedInput
                                placeholder="검색어를 입력하세요"
                                sx={{
                                    '& .MuiOutlinedInput-notchedOutline': {
                                        borderColor: 'red',
                                        borderWidth: '2px', // 테두리 두께를 1px로 고정
                                    },
                                    '&:hover .MuiOutlinedInput-notchedOutline': {
                                        borderColor: 'red',
                                        borderWidth: '2px',
                                    },
                                    '&.Mui-focused .MuiOutlinedInput-notchedOutline': {
                                        borderColor: 'red',
                                        borderWidth: '2px',
                                    },
                                }}
                            />
                        </FormControl>
                    </form>
                </Toolbar>
            </AppBar>
            {/*임시 배너*/}
            <Box sx={{ bgcolor: 'lightgray', p: 2 }}>
                <Swiper autoplay={true} pagination={true} navigation={true} modules={[Navigation , SwiperPagination , Autoplay]} className="mySwiper">
                    <SwiperSlide>
                        <CardMedia
                            sx={{ height: 200 }}
                            image={require("./sample/sample1.jpg")}
                            title="sample1"
                        />
                    </SwiperSlide>
                    <SwiperSlide>
                        <CardMedia
                            sx={{ height: 200 }}
                            image={require("./sample/sample1.jpg")}
                            title="sample1"
                        />
                    </SwiperSlide>
                    <SwiperSlide>
                        <CardMedia
                            sx={{ height: 200 }}
                            image={require("./sample/sample1.jpg")}
                            title="sample1"
                        />
                    </SwiperSlide>
                    <SwiperSlide>
                        <CardMedia
                            sx={{ height: 200 }}
                            image={require("./sample/sample1.jpg")}
                            title="sample1"
                        />
                    </SwiperSlide>
                    <SwiperSlide>
                        <CardMedia
                            sx={{ height: 200 }}
                            image={require("./sample/sample1.jpg")}
                            title="sample1"
                        />
                    </SwiperSlide>
                    <SwiperSlide>
                        <CardMedia
                            sx={{ height: 200 }}
                            image={require("./sample/sample1.jpg")}
                            title="sample1"
                        />
                    </SwiperSlide>
                </Swiper>
            </Box>
            {/*상품 정렬 타입 선택*/}
            <Box sx={{ display: 'flex', justifyContent: 'right', my: 2 }}>
                <ToggleButtonGroup
                    value={sortType}
                    exclusive
                    onChange={handleSortTypeChange}
                    aria-label="sort type"
                >
                    <ToggleButton value="popularity" aria-label="popularity">
                        인기순
                    </ToggleButton>
                    <ToggleButton value="recent" aria-label="recent">
                        최근순
                    </ToggleButton>
                    <ToggleButton value="lowPrice" aria-label="low price">
                        가격이 낮은순
                    </ToggleButton>
                    <ToggleButton value="highPrice" aria-label="high price">
                        가격이 높은순
                    </ToggleButton>
                </ToggleButtonGroup>
            </Box>
            {/*하단의 상품 정렬 페이지*/}
            <Grid container spacing={2} sx={{ padding: 2 }}>
                <Grid item xs={12} sm={6} md={4}>
                    <Card>
                        <CardContent>
                            <Typography gutterBottom variant="h5" component="div">
                                상품이름
                            </Typography>
                            <CardMedia
                                sx={{ height: 400 }}
                                image={require("./sample/sample1.jpg")}
                                title="sample1"
                            />
                            <Typography variant="body2" color="text.secondary">
                                가격 : 10000원
                            </Typography>
                        </CardContent>
                    </Card>
                </Grid>
                <Grid item xs={12} sm={6} md={4}>
                    <Card>
                        <CardContent>
                            <Typography gutterBottom variant="h5" component="div">
                                상품이름
                            </Typography>
                            <CardMedia
                                sx={{ height: 400 }}
                                image={require("./sample/sample1.jpg")}
                                title="sample1"
                            />
                            <Typography variant="body2" color="text.secondary">
                                가격 : 10000원
                            </Typography>
                        </CardContent>
                    </Card>
                </Grid>
                <Grid item xs={12} sm={6} md={4}>
                    <Card>
                        <CardContent>
                            <Typography gutterBottom variant="h5" component="div">
                                상품이름
                            </Typography>
                            <CardMedia
                                sx={{ height: 400 }}
                                image={require("./sample/sample1.jpg")}
                                title="sample1"
                            />
                            <Typography variant="body2" color="text.secondary">
                                가격 : 10000원
                            </Typography>
                        </CardContent>
                    </Card>
                </Grid>
                <Grid item xs={12} sm={6} md={4}>
                    <Card>
                        <CardContent>
                            <Typography gutterBottom variant="h5" component="div">
                                상품이름
                            </Typography>
                            <CardMedia
                                sx={{ height: 400 }}
                                image={require("./sample/sample1.jpg")}
                                title="sample1"
                            />
                            <Typography variant="body2" color="text.secondary">
                                가격 : 10000원
                            </Typography>
                        </CardContent>
                    </Card>
                </Grid>
                <Grid item xs={12} sm={6} md={4}>
                    <Card>
                        <CardContent>
                            <Typography gutterBottom variant="h5" component="div">
                                상품이름
                            </Typography>
                            <CardMedia
                                sx={{ height: 400 }}
                                image={require("./sample/sample1.jpg")}
                                title="sample1"
                            />
                            <Typography variant="body2" color="text.secondary">
                                가격 : 10000원
                            </Typography>
                        </CardContent>
                    </Card>
                </Grid>
                <Grid item xs={12} sm={6} md={4}>
                    <Card>
                        <CardContent>
                            <Typography gutterBottom variant="h5" component="div">
                                상품이름
                            </Typography>
                            <CardMedia
                                sx={{ height: 400 }}
                                image={require("./sample/sample1.jpg")}
                                title="sample1"
                            />
                            <Typography variant="body2" color="text.secondary">
                                가격 : 10000원
                            </Typography>
                        </CardContent>
                    </Card>
                </Grid>
            </Grid>
            {/*상품 이동 페이지네이션*/}
            <Box sx={{ display: 'flex', justifyContent: 'center', mt: 2 }}>
                <Pagination count={10} />
            </Box>
            {/*홈페이지의 최하단 네비게이션*/}
            <BottomNavigationAction label="Recents" icon={<MenuIcon />} />
            <BottomNavigationAction label="Favorites" icon={<MenuIcon />} />
            <BottomNavigationAction label="Nearby" icon={<MenuIcon />} />
            <AppBar position="static" sx={{ bgcolor: 'gray', color: 'black' ,height: 50}}>
                <Toolbar></Toolbar>
            </AppBar>
        </div>
    );
}
