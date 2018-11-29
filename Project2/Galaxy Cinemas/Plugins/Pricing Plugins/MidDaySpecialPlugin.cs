using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Common;
using Common.Business_Objects;

namespace GalaxyCinemas
{
    public class MidDaySpecialPlugin:ISpecialPlugin
    {
        public bool CalculateSpecial(Booking booking, ref string specialName, ref decimal specialPrice)
        {
            TimeSpan timeOfDay = booking.SessionDate.TimeOfDay;
            TimeSpan Start = new TimeSpan(11, 0, 0);
            TimeSpan End = new TimeSpan(13, 0, 0);
            if((Start<timeOfDay)&&(timeOfDay<End))
            {
                decimal discountedPrice;
                discountedPrice = booking.OriginalPrice*(decimal).8;
                specialPrice = discountedPrice;
                specialName = "Mid day special";
                return true;
            }
            else { return false; }

            
            // If not mid-day, not applicable.
            // If movie doesn't start between 11am and 1pm
              



            // Calculate the discounted price that we would offer.
         

       


            // If this discount is applicable, set specialName and specialPrice to our name and price.
           
            
        }
    }
}
