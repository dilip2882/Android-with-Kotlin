package com.dilip.ipl

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cricketTitleList = getCricketList()

    }

    private fun getCricketList(): ArrayList<CricketTitle>{
        return ArrayList<CricketTitle>().apply {
            add(
                CricketTitle(
                    id = "royal_challengers_banglore",
                    title = "Royal Challengers Banglore",
                    description = "Ee Sala Cup Namde",
                    descriptionLong = "Royal Challengers Bangalore (RCB), officially Royal Challengers Bengaluru, are a professional franchise cricket team based in Bangalore, Karnataka, playing in the Indian Premier League (IPL).",
                    buttonText = "Learn More",
                    headerImageResId = R.drawable.rcb,
                    headerImageUrl = "https://wallpapercave.com/wp/wp8792167.jpg"
                )
            )

            add(
                CricketTitle(
                    id = "chennai_super_kings",
                    title = "Chennai Super Kings",
                    description = "Yellow Pride",
                    descriptionLong = "Chennai Super Kings (CSK) are an Indian Premier League (IPL) franchise cricket team based in Chennai, Tamil Nadu, India.",
                    buttonText = "Learn More",
                    headerImageResId = R.drawable.csk,
                    headerImageUrl = "https://pbs.twimg.com/profile_banners/117407834/1716728989/1080x360"
                )
            )

            add(
                CricketTitle(
                    id = "delhi_capitals",
                    title = "Delhi Capitals",
                    description = "Dilliwala Swag",
                    descriptionLong = "Delhi Capitals are an Indian Premier League franchise based in Delhi, India. Founded in 2008 as Delhi Daredevils, it was renamed to Delhi Capitals in 2019.",
                    buttonText = "Learn More",
                    headerImageResId = R.drawable.dc,
                    headerImageUrl = "https://pbs.twimg.com/profile_banners/176888549/1711182263/1080x360"
                )
            )

            add(
                CricketTitle(
                    id = "kolkata_knight_riders",
                    title = "Kolkata Knight Riders",
                    description = "KKR",
                    descriptionLong = "Kolkata Knight Riders (KKR) are an Indian Premier League franchise cricket team based in Kolkata, West Bengal, India. Established in 2008, the team is owned by Bollywood actor Shah Rukh Khan, actress Juhi Chawla and her husband Jai Mehta.",
                    buttonText = "Learn More",
                    headerImageResId = R.drawable.kkr,
                    headerImageUrl = "https://pbs.twimg.com/profile_banners/23592970/1716764122/1080x360"
                )
            )

            add(
                CricketTitle(
                    id = "lucknow_super_giants",
                    title = "Lucknow Super Giants",
                    description = "New Era, New Champions",
                    descriptionLong = "Lucknow Super Giants are an Indian Premier League franchise cricket team based in Lucknow, Uttar Pradesh. Founded in 2021, the team is owned by RPSG Group.",
                    buttonText = "Learn More",
                    headerImageResId = R.drawable.lsg,
                    headerImageUrl = "https://pbs.twimg.com/profile_banners/4824087681/1715061946/1080x360"
                )
            )

            add(
                CricketTitle(
                    id = "mumbai_indians",
                    title = "Mumbai Indians",
                    description = "One Family. One Dream.",
                    descriptionLong = "Mumbai Indians (MI) are an Indian Premier League franchise cricket team based in Mumbai, Maharashtra. It is one of the most successful teams in the IPL, having won the title a record five times.",
                    buttonText = "Learn More",
                    headerImageResId = R.drawable.mi,
                    headerImageUrl = "https://pbs.twimg.com/profile_banners/106345557/1711875159/1080x360"
                )
            )

            add(
                CricketTitle(
                    id = "punjab_kings",
                    title = "Punjab Kings",
                    description = "SherSquad",
                    descriptionLong = "Punjab Kings (PBKS) are an Indian Premier League franchise cricket team based in Mohali, Punjab, India. It was one of the founding members of the league in 2008 and was named Kings XI Punjab until 2021.",
                    buttonText = "Learn More",
                    headerImageResId = R.drawable.pbks,
                    headerImageUrl = "https://pbs.twimg.com/profile_banners/30631766/1716187642/1080x360"
                )
            )

            add(
                CricketTitle(
                    id = "rajasthan_royals",
                    title = "Rajasthan Royals",
                    description = "Halla Bol!",
                    descriptionLong = "Rajasthan Royals (RR) are a professional franchise cricket team based in Jaipur, Rajasthan, that competes in the Indian Premier League (IPL).",
                    buttonText = "Learn More",
                    headerImageResId = R.drawable.rr,
                    headerImageUrl = "https://pbs.twimg.com/profile_banners/17082958/1713879322/1080x360" // RR image url

                )
            )
            add(
                CricketTitle(
                    id = "sunrisers_hyderabad",
                    title = "Sunrisers Hyderabad",
                    description = "Orange Army",
                    descriptionLong = "Sunrisers Hyderabad (SRH) are an Indian Premier League franchise based in Hyderabad, Telangana. It was one of the eight teams that bought the BCCI to contest in the IPL.",
                    buttonText = "Learn More",
                    headerImageResId = R.drawable.srh,
                    headerImageUrl = "https://pbs.twimg.com/profile_banners/989137039/1709706880/1080x360" // SRH image url

                )
            )
            add(
                CricketTitle(
                    id = "gujarat_titans",
                    title = "Gujarat Titans",
                    description = "GT Gujarat",
                    descriptionLong = "Gujarat Titans (GT) are a professional franchise cricket team based in Ahmedabad, Gujarat, that competes in the Indian Premier League (IPL).",
                    buttonText = "Learn More",
                    headerImageResId = R.drawable.gt,
                    headerImageUrl = "https://pbs.twimg.com/profile_banners/1476438846988427265/1715923934/1080x360" // GT image url

                )
            )
        }
    }
}