import { Pipe, PipeTransform } from '@angular/core';

@Pipe({name: 'appFilterLocation'})
export class LocationFilter implements PipeTransform
{
    transform(items: any[], searchText: string): any[] {
        if(!items)
        {
            return [];
        }

        if(!searchText)
        {
            return items;
        }

        searchText = searchText.toLocaleLowerCase();

        return items.filter(item => {
            return item.hospitalAddress.location.toLocaleLowerCase().includes(searchText);
        });
    }
}