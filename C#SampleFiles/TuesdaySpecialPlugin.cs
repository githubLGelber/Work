using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Common;
using Common.Business_Objects;

namespace GalaxyCinemas
{
    public class TuesdaySpecialPlugin : ISpecialPlugin
    {
        public bool CalculateSpecial(Booking booking, ref string specialName, ref decimal specialPrice)
        {
            // If not Tuesday, not applicable.
            DayOfWeek day = booking.SessionDate.DayOfWeek;
            if (day == DayOfWeek.Tuesday)
            {
                decimal basePrice = (booking.OriginalPrice) / (booking.Quantity);
                decimal discountedPrice = 0;
                if (booking.Quantity <= 5)
                {
                    discountedPrice = 11 * (booking.Quantity);
                }
                else
                {
                    discountedPrice = 11 * 5 + (basePrice * ((booking.Quantity) - 5));
                }
                if (discountedPrice < (booking.OriginalPrice))
                {
                    specialPrice = discountedPrice;
                    specialName = "Tuesday Special";
                }
                return true;

            }
            else { return false; }


            // Get base unit price.

            // Calculate the discounted price that we would offer.




            // If this discount is applicable, set specialName and specialPrice to our name and price.

        }
    }
}
